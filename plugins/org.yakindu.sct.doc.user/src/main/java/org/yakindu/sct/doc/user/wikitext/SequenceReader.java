package org.yakindu.sct.doc.user.wikitext;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * <p>
 * This class behaves like the standard {@link SequenceInputStream}, but for
 * {@link Reader}s. In fact its source code has been copied from
 * {@link SequenceInputStream} and then has been modified in order to cope with
 * the differences between {@link InputStream} and {@link Reader}.
 * 
 * @author Rainer Klute,
 *         <a href="mailto:rainer.klute@itemis.de">rainer.klute@itemise.de</a>,
 *         2017-08-28
 */
public class SequenceReader extends Reader {
    Enumeration<? extends Reader> e;
    Reader in;

    /**
     * Initializes a newly created <code>SequenceReader</code> by remembering
     * the argument, which must be an <code>Enumeration</code> that produces
     * objects whose run-time type is <code>Reader</code>. The readers that are
     * produced by the enumeration will be read, in order, to provide the
     * characters to be read from this <code>SequenceReader</code>. After each
     * reader from the enumeration is exhausted, it is closed by calling its
     * <code>close</code> method.
     *
     * @param e
     *            an enumeration of readers.
     * @see java.util.Enumeration
     */
    public SequenceReader(Enumeration<? extends Reader> e) {
        this.e = e;
        try {
            nextReader();
        } catch (IOException ex) {
            // This should never happen
            throw new Error("panic");
        }
    }

    /**
     * Initializes a newly created <code>SequenceReader</code> by remembering
     * the two arguments, which will be read in order, first <code>s1</code> and
     * then <code>s2</code>, to provide the characters to be read from this
     * <code>SequenceReader</code>.
     *
     * @param s1
     *            the first reader to read.
     * @param s2
     *            the second reader to read.
     */
    public SequenceReader(Reader s1, Reader s2) {
        Vector<Reader> v = new Vector<>(2);

        v.addElement(s1);
        v.addElement(s2);
        e = v.elements();
        try {
            nextReader();
        } catch (IOException ex) {
            // This should never happen
            throw new Error("panic");
        }
    }

    /**
     * Continues reading in the next reader if an EOF is reached.
     */
    final void nextReader() throws IOException {
        if (in != null) {
            in.close();
        }

        if (e.hasMoreElements()) {
            in = (Reader) e.nextElement();
            if (in == null)
                throw new NullPointerException();
        } else
            in = null;

    }

    /**
     * Returns an estimate of the number of characters that can be read (or
     * skipped over) from the current underlying reader without blocking by the
     * next invocation of a method for the current underlying reader. The next
     * invocation might be the same thread or another thread. A single read or
     * skip of this many characters will not block, but may read or skip fewer
     * characters.
     * <p>
     * This method simply calls {@code available} of the current underlying
     * reader and returns the result.
     *
     * @return an estimate of the number of characters that can be read (or
     *         skipped over) from the current underlying reader without blocking
     *         or {@code 0} if this reader has been closed by invoking its
     *         {@link #close()} method
     * @exception IOException
     *                if an I/O error occurs.
     *
     * @since JDK1.1
     */
    // public int available() throws IOException {
    // if (in == null) {
    // return 0; // no way to signal EOF from available()
    // }
    // return in.available();
    // }

    /**
     * Reads the next character of data from this reader. The character is
     * returned as an <code>int</code> in the range <code>0</code> to
     * <code>255</code>. If no character is available because the end of the
     * reader has been reached, the value <code>-1</code> is returned. This
     * method blocks until input data is available, the end of the reader is
     * detected, or an exception is thrown.
     * <p>
     * This method tries to read one character from the current subreader. If it
     * reaches the end of the reader, it calls the <code>close</code> method of
     * the current subreader and begins reading from the next subreader.
     *
     * @return the next character of data, or <code>-1</code> if the end of the
     *         reader is reached.
     * @exception IOException
     *                if an I/O error occurs.
     */
    public int read() throws IOException {
        while (in != null) {
            int c = in.read();
            if (c != -1) {
                return c;
            }
            nextReader();
        }
        return -1;
    }

    /**
     * Reads up to <code>len</code> characters of data from this reader into an
     * array of characters. If <code>len</code> is not zero, the method blocks
     * until at least 1 character of input is available; otherwise, no
     * characters are read and <code>0</code> is returned.
     * <p>
     * The <code>read</code> method of <code>SequenceReader</code> tries to read
     * the data from the current subreader. If it fails to read any characters
     * because the subreader has reached the end of the reader, it calls the
     * <code>close</code> method of the current subreader and begins reading
     * from the next subreader.
     *
     * @param b
     *            the buffer into which the data is read.
     * @param off
     *            the start offset in array <code>b</code> at which the data is
     *            written.
     * @param len
     *            the maximum number of characters read.
     * @return int the number of characters read.
     * @exception NullPointerException
     *                If <code>b</code> is <code>null</code>.
     * @exception IndexOutOfBoundsException
     *                If <code>off</code> is negative, <code>len</code> is
     *                negative, or <code>len</code> is greater than
     *                <code>b.length - off</code>
     * @exception IOException
     *                if an I/O error occurs.
     */
    public int read(char b[], int off, int len) throws IOException {
        if (in == null) {
            return -1;
        } else if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }
        do {
            int n = in.read(b, off, len);
            if (n > 0) {
                return n;
            }
            nextReader();
        } while (in != null);
        return -1;
    }

    /**
     * Closes this reader and releases any system resources associated with it.
     * A closed <code>SequenceReader</code> cannot perform input operations and
     * cannot be reopened.
     * <p>
     * If this reader was created from an enumeration, all remaining elements
     * are requested from the enumeration and closed before the
     * <code>close</code> method returns.
     *
     * @exception IOException
     *                if an I/O error occurs.
     */
    public void close() throws IOException {
        do {
            nextReader();
        } while (in != null);
    }

}
