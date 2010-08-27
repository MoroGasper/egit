import org.eclipse.jgit.diff.DiffEntry.ChangeType;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
		if (commit.getParentCount() > 0)
			walk.reset(trees(commit));
		else {
			walk.reset();
			walk.addTree(new EmptyTreeIterator());
			walk.addTree(commit.getTree());
		}
		ObjectReader reader = db.newObjectReader();
		try {
			outputEclipseDiff(d, db, reader, diffFmt);
		} finally {
			reader.release();
		}
			final ObjectReader reader, final DiffFormatter diffFmt)
			throws IOException {
		d.append("index ").append(reader.abbreviate(id1).name()). //$NON-NLS-1$
				append("..").append(reader.abbreviate(id2).name()). //$NON-NLS-1$
		final RawText a = getRawText(id1, reader);
		final RawText b = getRawText(id2, reader);
	private RawText getRawText(ObjectId id, ObjectReader reader)
			throws IOException {
			return new RawText(new byte[] {});
		ObjectLoader ldr = reader.open(id, Constants.OBJ_BLOB);
		return new RawText(ldr.getCachedBytes(Integer.MAX_VALUE));