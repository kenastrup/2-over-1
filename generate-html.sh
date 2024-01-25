#!/bin/zsh
asciidoctor \
  --base-dir src/main/asciidoc \
  --backend html5\
  --destination-dir out \
  --section-numbers \
  src/main/asciidoc/2-over-1.adoc
