<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:d="http://docbook.org/ns/docbook" version="1.0">

 <xsl:import href="@docbook-xsl@/html/docbook.xsl"/>


 <xsl:import href="common-params.xsl"/>
 <xsl:import href="common-html-rules.xsl"/>


 <xsl:param name="base.dir">html</xsl:param>
 
 <xsl:template name="user.header.content">
  <p style="background-color: #95c0f3; text-align: right; font-weight: bold">YAKINDU Statechart Tools</p>
</xsl:template>

 <xsl:template name="user.footer.content">
  <p style="background-color: #95c0f3; text-align: right; font-weight: bold">YAKINDU Statechart Tools</p>
</xsl:template>

<xsl:template
 match="d:section[@role = 'to-be-written'] | d:sect1[@role = 'to-be-written'] | d:sect2[@role = 'to-be-written'] | d:sect3[@role = 'to-be-written'] | d:sect4[@role = 'to-be-written'] | d:sect5[@role = 'to-be-written']">
 <xsl:text><!-- The section missing here will be provided later. --></xsl:text>
</xsl:template>

</xsl:stylesheet>