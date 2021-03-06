/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.command.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import org.eclipse.che.ide.ui.menubutton.MenuPopupButton;

import javax.inject.Inject;
import javax.inject.Singleton;

/** Implementation of {@link CommandToolbarView}. */
@Singleton
public class CommandToolbarViewImpl implements CommandToolbarView {

    private static final CommandToolbarViewImplUiBinder UI_BINDER = GWT.create(CommandToolbarViewImplUiBinder.class);

    @UiField
    FlowPanel   rootPanel;
    @UiField
    SimplePanel commandsPanel;
    @UiField
    SimplePanel processesListPanel;
    @UiField
    SimplePanel buttonsPanel;
    @UiField
    SimplePanel previewUrlListPanel;

    private ActionDelegate delegate;

    @Inject
    public CommandToolbarViewImpl() {
        UI_BINDER.createAndBindUi(this);
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Widget asWidget() {
        return rootPanel;
    }

    @Override
    public AcceptsOneWidget getCommandsPanelContainer() {
        return commandsPanel;
    }

    @Override
    public AcceptsOneWidget getProcessesListContainer() {
        return processesListPanel;
    }

    @Override
    public AcceptsOneWidget getPreviewUrlsListContainer() {
        return previewUrlListPanel;
    }

    @Override
    public void addButton(MenuPopupButton button) {
        buttonsPanel.add(button);
    }

    interface CommandToolbarViewImplUiBinder extends UiBinder<Widget, CommandToolbarViewImpl> {
    }
}
