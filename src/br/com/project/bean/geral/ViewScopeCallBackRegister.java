package br.com.project.bean.geral;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructViewMapEvent;
import javax.faces.event.PreDestroyViewMapEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.ViewMapListener;

@SuppressWarnings("unchecked")
public class ViewScopeCallBackRegister implements ViewMapListener {

	@Override
	public boolean isListenerForSource(Object source) {
		return source instanceof UIViewRoot;
	}

	@Override
	public void processEvent(SystemEvent systemEvent)
			throws AbortProcessingException {

		if (systemEvent instanceof PostConstructViewMapEvent) {

			PostConstructViewMapEvent viewMapEvent = (PostConstructViewMapEvent) systemEvent;
			UIViewRoot uiViewRoot = (UIViewRoot) viewMapEvent.getComponent();
			uiViewRoot.getViewMap().put(ViewScope.VIEW_SCOPE_CALLBACK,
					new HashMap<String, Runnable>());

		} else if (systemEvent instanceof PreDestroyViewMapEvent) {

			PreDestroyViewMapEvent viewMapEvent = (PreDestroyViewMapEvent) systemEvent;
			UIViewRoot viewRoot = (UIViewRoot) viewMapEvent.getComponent();
			Map<String, Runnable> callBacks = (Map<String, Runnable>) viewRoot
					.getViewMap().get(ViewScope.VIEW_SCOPE_CALLBACK);

			if (callBacks != null) {

				for (Runnable runnable : callBacks.values()) {
					runnable.run();
				}

				callBacks.clear();
			}
		}
	}

}
