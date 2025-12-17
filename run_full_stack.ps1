# Archivo: run_full_stack.ps1

# Requisitos: Docker Desktop y PostgreSQL 17 instalados

Write-Host "Deteniendo y eliminando contenedores existentes..."
docker compose down -v

# ---------------------------
# Build de microservicios
# ---------------------------

$services = @(
    @{path="API-productService"; tag="product_service:1.0"},
    @{path="gateway"; tag="imperium-rooms-gateway:1.0"},
    @{path="imperiumRoomsDS3"; tag="imperiumrooms:1.1"},
    @{path="AuthUsers"; tag="auth-service:1.0"},
    @{path="hotel-reservation-app"; tag="imperium-rooms-app:1.0"}
)

foreach ($svc in $services) {
    Write-Host "Construyendo $($svc.tag) desde $($svc.path)..."
    Push-Location $svc.path
    docker build -t $($svc.tag) .
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Error construyendo $($svc.tag)"
        exit $LASTEXITCODE
    }
    Pop-Location
}

# ---------------------------
# Levantar backend
# ---------------------------

Write-Host "Construyendo y levantando contenedores de backend..."
docker compose build
docker compose up -d
if ($LASTEXITCODE -ne 0) {
    Write-Error "Error levantando backend"
    exit $LASTEXITCODE
}

# ---------------------------
# Levantar frontend
# ---------------------------

Write-Host "Levantando frontend en http://localhost:5173..."
docker run --rm -p 5173:80 imperium-rooms-app:1.0

Write-Host "Todo levantado correctamente"
