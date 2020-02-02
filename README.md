# gcp-circle

勉強会用のサンプルアプリ。

## Usage

#### docker起動

```bash
$ docker-compose up -d
```

#### ui起動

uiコンテナに入ってコマンド実行
```bash
$ docker exec -ti ui-container /bin/sh
$ npm install
$ npm run dev
```

下記にアクセス

http://127.0.0.1:3000/
