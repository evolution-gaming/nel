# Nel [![Build Status](https://travis-ci.org/evolution-gaming/nel.svg)](https://travis-ci.org/evolution-gaming/nel) [![Coverage Status](https://coveralls.io/repos/evolution-gaming/nel/badge.svg)](https://coveralls.io/r/evolution-gaming/nel) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/7c230889a4094f57b1c27788b972fb72)](https://app.codacy.com/gh/evolution-gaming/nel/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade) [ ![version](https://api.bintray.com/packages/evolutiongaming/maven/nel/images/download.svg) ](https://bintray.com/evolutiongaming/maven/nel/_latestVersion) [![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

### Single class library with non empty list inside

```scala
  import com.evolutiongaming.nel.Nel
  
  scala> Nel(1, 2)
  res0: com.evolutiongaming.nel.Nel[Int] = Nel(1, 2)
```

## Setup

```scala
resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies += "com.evolutiongaming" %% "nel" % "1.3.4"
```
