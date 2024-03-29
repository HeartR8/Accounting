name := "AccountingSystem"
version := "0.0.1"
scalaVersion := "2.13.1"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.9"
libraryDependencies += "com.typesafe.akka" %% "akka-http"   % "10.1.11"
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.1.11"
libraryDependencies += "com.softwaremill.akka-http-session" %% "core" % "0.5.10"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.26"
libraryDependencies += "com.typesafe" % "config" % "1.4.0"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.11"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.2"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.26"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2"
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
libraryDependencies += "org.mockito" %% "mockito-scala" % "1.10.4"
libraryDependencies += "com.beachape" %% "enumeratum" % "1.7.2"