# Nel [![Build Status](https://travis-ci.org/evolution-gaming/nel.svg)](https://travis-ci.org/evolution-gaming/nel) [![Coverage Status](https://coveralls.io/repos/evolution-gaming/nel/badge.svg)](https://coveralls.io/r/evolution-gaming/nel) [ ![version](https://api.bintray.com/packages/evolutiongaming/maven/nel/images/download.svg) ](https://bintray.com/evolutiongaming/maven/nel/_latestVersion)

### Single class library with non empty list inside

```scala
  import com.evolutiongaming.nel.Nel
  
  scala> Nel(1, 2)
  res0: com.evolutiongaming.nel.Nel[Int] = Nel(1, 2)
```

## Setup

```scala
resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies += "com.evolutiongaming" %% "nel" % "1.0"
```
