FROM debian:bullseye-slim

RUN apt-get update && apt-get install -y curl ca-certificates \
  && curl -Lo /usr/local/bin/alloydb-auth-proxy https://storage.googleapis.com/alloydb-auth-proxy/v1.4.0/alloydb-auth-proxy.linux.amd64 \
  && chmod +x /usr/local/bin/alloydb-auth-proxy

ENTRYPOINT ["/usr/local/bin/alloydb-auth-proxy"]