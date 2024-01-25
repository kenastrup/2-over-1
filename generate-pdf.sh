#!/bin/zsh
asciidoctorpdf \
  --base-dir src/main/asciidoc \
  --destination-dir out \
  --section-numbers \
  -a pdf-fontsdir=src/main/resources/fonts \
  -a pdf-themesdir=src/main/resources/themes \
  src/main/asciidoc/2-over-1.adoc
