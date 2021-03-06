/*******************************************************************************
 * Copyright (c) 2011, Matthias Sohn <matthias.sohn@sap.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.egit.ui.internal.reflog.command;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.egit.ui.internal.commit.CommitEditor;
import org.eclipse.egit.ui.internal.commit.RepositoryCommit;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

/**
 * Handler to open commit in commit viewer
 */
public class OpenInCommitViewerHandler extends AbstractReflogCommandHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Repository repository = getRepository(event);
		RevCommit commit = getSelectedCommit(event, repository);
		if (commit != null)
			CommitEditor.openQuiet((new RepositoryCommit(repository, commit)));
		return null;
	}

}
