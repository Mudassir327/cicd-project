# -------------------------------
# FIXED React Frontend Dockerfile
# -------------------------------

# 1️⃣ Build Stage
FROM node:18-alpine AS build

WORKDIR /app

# Copy only package files first (better caching)
COPY package*.json ./

RUN npm install

# Copy entire React project
COPY . .

# Build React app
RUN npm run build

# 2️⃣ Production Nginx Stage
FROM nginx:stable-alpine

# Copy build files into nginx html folder
COPY --from=build /app/build /usr/share/nginx/html

# Copy nginx.conf
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
