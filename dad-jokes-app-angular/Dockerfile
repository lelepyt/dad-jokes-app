# Build stage
FROM node:20-alpine AS builder
WORKDIR /app
COPY . .
RUN npm install && npm run build


# Production stage
FROM nginx:stable-alpine
COPY --from=builder /app/dist/dad-jokes-app-angular /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf