# rf-mater

## Shadow Server

To run the following commands faster, spin up a background shadow server:

```
npm run shadow-start
```

You only need to do this once for the shell session.


## Development Mode

```
npm run dev
```

## Production Build

Stop the `dev` process, if running.

```
npm run release
```

Test release by running server:

```
npm run serve
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
