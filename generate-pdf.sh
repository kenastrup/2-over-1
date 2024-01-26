#!/bin/zsh
asciidoctor-pdf \
  --base-dir src/main/asciidoc \
  --destination-dir out \
  --section-numbers \
  --attribute pdf-fontsdir=src/main/resources/fonts:/Library/Ruby/Gems/2.6.0/gems/asciidoctor-pdf-2.3.11/data/fonts \
  --attribute pdf-themesdir=src/main/resources/themes \
  --attribute pdf-theme=bridge \
  --trace \
  src/main/asciidoc/2-over-1.adoc
