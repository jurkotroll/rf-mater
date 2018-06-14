# rf-mater

## Shadow Server

To run the following commands faster, spin up a background shadow server:

```
yarn shadow-start
```

You only need to do this once for the shell session.


## Development Mode

```
yarn dev
```

## Production Build

Stop the `dev` process, if running.

```
yarn release
```

Test release by running server:

```
yarn serve
```

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
