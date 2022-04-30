FROM node:14.17.1
WORKDIR /app
RUN yarn global add @vue/cli
COPY . .
EXPOSE 8080
CMD [ "npm", "run", "serve" ]