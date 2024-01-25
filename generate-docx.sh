#!/bin/zsh
asciidoctor \
  --base-dir src/main/asciidoc \
  --backend docbook\
  --destination-dir out \
  --section-numbers \
  --out-file - \
  src/main/asciidoc/2-over-1.adoc \
  | \
pandoc \
  --from docbook \
  --to docx \
  --out 2-over-1.docx
