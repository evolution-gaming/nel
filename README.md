# Nel [![Build Status](https://travis-ci.org/evolution-gaming/nel.svg)](https://travis-ci.org/evolution-gaming/nel) [![Coverage Status](https://coveralls.io/repos/evolution-gaming/nel/badge.svg)](https://coveralls.io/r/evolution-gaming/nel) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/97f65df37dcd4941b409ab317eace38e)](https://www.codacy.com/app/evolution-gaming/nel?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/nel&amp;utm_campaign=Badge_Grade) [ ![version](https://api.bintray.com/packages/evolutiongaming/maven/nel/images/download.svg) ](https://bintray.com/evolutiongaming/maven/nel/_latestVersion) [![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

### Single class library with non empty list inside

```scala
  import com.evolutiongaming.nel.Nel
  
  scala> Nel(1, 2)
  res0: com.evolutiongaming.nel.Nel[Int] = Nel(1, 2)
```

## Setup

```scala
resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies += "com.evolutiongaming" %% "nel" % "1.3.3"
```
