(defproject bleach "0.0.10"
  :description "Whitens unsightly code"
  :url "http://github.com/dlowe/bleach"
  :license {:name "Artistic License" :url "http://dev.perl.org/licenses/artistic.html"}
  :eval-in-leiningen true
  :aliases {"jar" ["trampoline" "jar"]
            "push" ["trampoline" "push"]}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main bleach.core)
