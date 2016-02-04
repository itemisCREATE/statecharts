<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

 <xsl:template match="informaltable[@role]" mode="class.value">
  <xsl:value-of select="@role"/>
 </xsl:template>

 <xsl:template match="application[child::text() = 'YAKINDU Statechart Tools']" mode="class.value">
  <xsl:value-of select="'application-ysct'"/>
 </xsl:template>

</xsl:stylesheet>