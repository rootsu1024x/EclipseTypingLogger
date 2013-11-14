package net.caffeineswitch.eclipse.plugin.strknumlogger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.keys.BindingService;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.part.ViewPart;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("restriction")
public class KeyStrokeLogger extends ViewPart {
	private static Button logSwitcher;
	private static boolean logging = false;
	private static Timer timer;
	public static void setKeyListener() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		final Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if(logging){
					KeyStrokeLog.incrementLog();
					System.out.println("logged");
				}
			}
		};
		IBindingService iBindingService = (IBindingService) workbench.getService(IBindingService.class);
		if (iBindingService instanceof BindingService) {
			BindingService bindingService = (BindingService) iBindingService;
			try {
				if (bindingService.getKeyboard().getKeyDownFilter() != null) {
					display.removeFilter(SWT.KeyDown, bindingService
							.getKeyboard().getKeyDownFilter());
				}
				display.addFilter(SWT.KeyDown, listener);
			} finally {
				if (bindingService.getKeyboard().getKeyDownFilter() != null) {
					display.addFilter(SWT.KeyDown, bindingService.getKeyboard()
							.getKeyDownFilter());
				}
			}
		} else {
			display.addFilter(SWT.KeyDown, listener);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		logSwitcher = new Button(parent,0);
		logSwitcher.setText("ロギング無効・クリックで有効化");
		logSwitcher.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				logging = !logging;
				if(logging){
					logSwitcher.setText("ロギング有効・クリックで無効化");
					CSVLogger.logging(System.currentTimeMillis()/1000l, -1);
					timer = new Timer(true);
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							CSVLogger.logging(System.currentTimeMillis()/1000l, KeyStrokeLog.getNum());
							KeyStrokeLog.resetNum();
						}
					}, 60000,60000);
				}else{
					logSwitcher.setText("ロギング無効・クリックで有効化");
					if (timer != null) {
						timer.cancel();
						timer = null;
					}
				}
			}
			@Override
			public void mouseDown(MouseEvent e) {
			}
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}

	@Override
	public void setFocus() {
	}
}
