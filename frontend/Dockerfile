FROM node:16-alpine
WORKDIR /app
COPY package.json /app/package.json
COPY package-lock.json /app/package-lock.json

RUN npm ci
COPY . /app

ENV CI=true
ENV PORT=3000
EXPOSE 3000
CMD [ "npm", "start" ]