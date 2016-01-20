<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

 <xsl:import href="../../org.yakindu.sct.doc.docbook-xsl/eclipse/eclipse.xsl"/>


 <xsl:import href="common-params.xsl"/>
 <xsl:import href="common-html-rules.xsl"/>

 <xsl:param name="base.dir">help</xsl:param>
 <xsl:param name="chunked.filename.prefix">structure-</xsl:param>
 <xsl:param name="manifest">0</xsl:param>
 <xsl:param name="create.plugin.xml">0</xsl:param>



 <xsl:template match="*[contains(@role, 'stext_') or contains(@role, 'sgen_') ]">
  <xsl:variable name="start_marker"><xsl:text> Start </xsl:text><xsl:value-of select="@role"/><xsl:text> </xsl:text></xsl:variable>
  <xsl:variable name="end_marker"><xsl:text> End </xsl:text><xsl:value-of select="@role"/><xsl:text> </xsl:text></xsl:variable>
  <xsl:comment><xsl:value-of select="$start_marker"/></xsl:comment>
  <xsl:apply-imports/>
  <xsl:comment><xsl:value-of select="$end_marker"/></xsl:comment>
 </xsl:template>

</xsl:stylesheet>