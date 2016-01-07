<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

 <xsl:import href="../../org.yakindu.sct.doc.docbook/eclipse/eclipse.xsl"/>

 <xsl:template match="informaltable[@role]" mode="class.value">
  <xsl:value-of select="@role"/>
 </xsl:template>

 <xsl:template match="application[child::text() = 'YAKINDU Statechart Tools']" mode="class.value">
  <xsl:value-of select="'application-ysct'"/>
 </xsl:template>

 <xsl:template match="*[contains(@role, 'stext_') or contains(@role, 'sgen_') ]">
  <xsl:variable name="start_marker"><xsl:text> Start </xsl:text><xsl:value-of select="@role"/><xsl:text> </xsl:text></xsl:variable>
  <xsl:variable name="end_marker"><xsl:text> End </xsl:text><xsl:value-of select="@role"/><xsl:text> </xsl:text></xsl:variable>
  <xsl:comment><xsl:value-of select="$start_marker"/></xsl:comment>
  <xsl:apply-imports/>
  <xsl:comment><xsl:value-of select="$end_marker"/></xsl:comment>
 </xsl:template>

</xsl:stylesheet>