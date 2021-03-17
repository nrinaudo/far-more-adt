enablePlugins(TutPlugin, GhpagesPlugin)

organization := "com.nrinaudo"
scalaVersion := "2.13.0"

val tutDirName = settingKey[String]("tut output directory")
tutDirName := "./"

val graphvizDirName = settingKey[String]("graphviz output directory")
graphvizDirName := "./img"

val graphviz = taskKey[Seq[(File, String)]]("compile all dot files")
graphviz := {
  import scala.sys.process._

  val files = (sourceDirectory.value / "graphviz") ** "*.dot"
  val outDir = target.value / "graphviz"

  outDir.mkdirs

  files.get.map { file =>
    val outFile = file.getName().replace(".dot", ".svg")
    val outPath = outDir / outFile

    s"dot -Tsvg $file -o $outPath" !

    (outPath, outFile)
  }
}

addMappingsToSiteDir(tut, tutDirName)
addMappingsToSiteDir(graphviz, graphvizDirName)
includeFilter in SitePlugin.autoImport.makeSite :=
    "*.yml" | "*.md" | "*.html" | "*.css" | "*.png" | "*.jpg" | "*.gif" | "*.js" | "*.eot" | "*.svg" | "*.ttf" |
    "*.woff" | "*.woff2" | "*.otf"

git.remoteRepo := "git@github.com:nrinaudo/far-mode-adt.git"


(scalacOptions in Tut) += "-Xfatal-warnings"
