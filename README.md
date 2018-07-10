# rf-mater

## Installation

```
npm install -g yarn
npm install -g firebase
```

## Shadow Server
My way:
1 shell window:
-> strat server:
$ shadow-cljs clj-repl
in CLJ-REPL:
(shadow/watch :app)
- > connect to:
http://localhost:3000/
= success: "JS tuntime connected"

2 shell window:
just git

3 bash window cygwin:
-> start REPL:


To run the following commands faster, spin up a background shadow server:

```
yarn shadow-start
```

You only need to do this once for the shell session. At the end of session you can stop with:

```
yarn shadow-stop
```


## Development Mode

```
yarn dev
```

Server running at <http://localhost:3000>

## Production Build

Stop the `dev` process, if running.

```
yarn release
```

Test release by running release server:

```
yarn serve
```

Server running at <http://localhost:8080>

## Deployment

Setup firebase:

```
firebase login
```

Setup `.firebaserc`:

```
$ cat .firebaserc
{
  "projects": {
    "default": "jurkodemo"
  }
}
```

Deploy:

```
firebase deploy
```
