package gui.view.SideButtonBar;

import gui.command.*;
import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import javafx.scene.layout.VBox;

public class SideBarView {

    protected SideButtonView openBtn;
    protected SideButtonView startBtn;
    protected SideButtonView stopBtn;
    protected SideButtonView pauseBtn;
    protected SideButtonView restartBtn;
    protected SideButtonView monitoringBtn;
    protected VBox sideLeftBar;

    protected SideBarView() {

    }

    public static SideBarView create(final ProcessController processController, final ChooseFileController chooseFileController, final ExecutableFile executableFile) {

        if (processController == null)
            return null;
        if (chooseFileController == null)
            return null;
        if (executableFile == null)
            return null;

        SideBarView sideBarView = new SideBarView();

        sideBarView.sideLeftBar = new VBox();
        sideBarView.sideLeftBar.getStyleClass().add("sidebar");

        sideBarView.openBtn = SideButtonView.create("openBtn", ChooseFileCommand.create(chooseFileController, executableFile));
        sideBarView.startBtn = SideButtonView.create("startBtn", StartProcessCommand.create(processController, executableFile));
        sideBarView.stopBtn = SideButtonView.create("stopBtn", StopProcessCommand.create(processController, executableFile));
        sideBarView.pauseBtn = SideButtonView.create("pauseBtn", PauseProcessCommand.create(processController, executableFile));
        sideBarView.restartBtn = SideButtonView.create("restartBtn", RestartProcessCommand.create(processController, executableFile));
        sideBarView.monitoringBtn = SideButtonView.create("monitoringBtn", StartMonitoringCommand.create(processController));

        sideBarView.sideLeftBar.getChildren().addAll(sideBarView.openBtn.getSideButton(), sideBarView.startBtn.getSideButton(), sideBarView.stopBtn.getSideButton(),
                sideBarView.restartBtn.getSideButton(), sideBarView.monitoringBtn.getSideButton());

        return sideBarView;
    }

    public VBox getSideLeftBar() {
        return sideLeftBar;
    }

    public SideButtonView getOpenBtn() {
        return openBtn;
    }

    public SideButtonView getStartBtn() {
        return startBtn;
    }

    public SideButtonView getStopBtn() {
        return stopBtn;
    }

    public SideButtonView getPauseBtn() {
        return pauseBtn;
    }

    public SideButtonView getRestartBtn() {
        return restartBtn;
    }

    public SideButtonView getMonitoringBtn() {
        return monitoringBtn;
    }
}
