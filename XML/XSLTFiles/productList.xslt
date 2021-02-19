<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">

                </style>
            </head>

            <body>
                <table>
                    <tr>
                        <th>Product Code</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Stock</th>
                    </tr>
                    <xsl:for-each select="ProductList/Product">
                        <tr>
                            <td>
                                <xsl:value-of select="productId"/>
                            </td>
                            <td>
                                <xsl:value-of select="productName"/>
                            </td>
                            <td>
                                <xsl:value-of select="price"/>
                            </td>
                            <td>
                                <xsl:value-of select="stock"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>