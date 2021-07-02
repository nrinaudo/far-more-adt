enablePlugins(GhpagesPlugin)

organization := "com.nrinaudo"
scalaVersion := "3.0.1-RC2"
graphvizStylesheet := Some(graphvizSourceDirectory.value / "style.dss")


SitePlugin.autoImport.makeSite / includeFilter :=
    "*.yml" | "*.md" | "*.html" | "*.css" | "*.png" | "*.jpg" | "*.gif" | "*.js" | "*.eot" | "*.svg" | "*.ttf" |
    "*.woff" | "*.woff2" | "*.otf"

git.remoteRepo := "git@github.com:nrinaudo/far-mode-adt.git"


MdRepl / scalacOptions += "-Xfatal-warnings"
