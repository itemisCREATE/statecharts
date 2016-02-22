<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

 <!-- Don't have DocBook XSL render navigation links. -->
 <xsl:param name="suppress.navigation">1</xsl:param>

 <!-- This CSS stylesheet is to be referenced from generated HTML files. -->
 <xsl:param name="html.stylesheet">css/style.css</xsl:param>

 <!-- Enables section numbering. -->
 <xsl:param name="section.autolabel">1</xsl:param>

 <!-- Specifies the maximum depth of section numbers. -->
 <xsl:param name="section.autolabel.max.depth">4</xsl:param>

 <!-- Don't render <remark> elements. -->
 <xsl:param name="show.comments" select="0"></xsl:param>

 <!-- Specifies the maximum depth of the section hierarchy to be included in the TOC. -->
 <xsl:param name="toc.section.depth">10</xsl:param>
 
 <!-- Image URLs should be interpreted as being relative to the xml:base. -->
 <xsl:param name="keep.relative.image.uris">0</xsl:param>

 <!--  Specifies where a title is to be placed relative to the object it describes. -->
 <xsl:param name="formal.title.placement">
  figure after
  example before
  equation before
  table before
  procedure before
  task before
 </xsl:param>

</xsl:stylesheet>