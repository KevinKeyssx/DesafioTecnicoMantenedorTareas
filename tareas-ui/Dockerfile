FROM node:16.13.1 AS build

WORKDIR /app

COPY package.json ./

RUN npm install

COPY . .

RUN npm run build --dev

#Segunda etapa
FROM nginx:1.17.1-alpine AS prod-stage

COPY --from=build /app/dist/tareas-ui /usr/share/nginx/html
EXPOSE 1700
CMD ["nginx", "-g", "daemon off;"]