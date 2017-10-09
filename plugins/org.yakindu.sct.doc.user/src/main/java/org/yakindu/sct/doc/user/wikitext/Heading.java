package org.yakindu.sct.doc.user.wikitext;

/**
 * <p>
 * Represents a heading in a Wikitext document. Its attributes are as follows:
 * </p>
 * 
 * <dl>
 * <dt><em>resource</em></dt>
 * <dd>
 * <p>
 * The resource the heading is in, typically a filename
 * </p>
 * </dd>
 * <dt><em>level</em></dt>
 * <dd>
 * <p>
 * The heading's level, typically in the range 1 – 6
 * </p>
 * </dd>
 * <dt><em>id</em></dt>
 * <dd>
 * <p>
 * The heading's ID, if it has one
 * </p>
 * </dd>
 * <dt><em>title</em></dt>
 * <dd>
 * <p>
 * The heading's title text
 * </p>
 * </dd>
 * </dl>
 * 
 * @author Rainer Klute,
 *         <a href="mailto:rainer.klute@itemis.de">rainer.klute@itemise.de</a>,
 *         2017-08-28
 */
public class Heading {

    private String resource;
    private int level;
    private String id;
    private StringBuilder title;

    public Heading(final String resource, final int level, final String id) {
        this.resource = resource;
        this.level = level;
        this.id = id;
    }

    public Heading(final String resource, final int level, final String id, final String title) {
        this(resource, level, id);
        this.title = new StringBuilder(title);
    }

    public String getResource() {
        return resource;
    }

    public void setResource(final String resource) {
        this.resource = resource;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title != null ? title.toString() : null;
    }

    public void setTitle(final String title) {
        this.title = new StringBuilder(title);
    }

    public void appendToTitle(final String text) {
        this.title.append(text);
    }

    @Override
    public String toString() {
        final StringBuilder b = new StringBuilder();
        b.append("Heading[level=");
        b.append(level);
        b.append(", text=");
        b.append(title);
        b.append(", id=");
        b.append(id);
        b.append(", resource=");
        b.append(resource);
        b.append("]");
        return b.toString();
    }

}
