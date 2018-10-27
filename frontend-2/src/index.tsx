import * as React from "react";
import * as ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { applyMiddleware, createStore } from "redux";
import { composeWithDevTools } from "redux-devtools-extension";
import createSagaMiddleware from "redux-saga";
import App from "./app/App";
import registerServiceWorker from "./core/registerServiceWorker";
import "./index.css";
import rootReducer from "./rootReducer";
import rootSaga from "./rootSaga";

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  rootReducer,
  // @ts-ignore
  composeWithDevTools(),
  applyMiddleware(sagaMiddleware)
);
sagaMiddleware.run(rootSaga);

function render() {
  ReactDOM.render(
    <Provider store={store}>
      <App />
    </Provider>,
    document.getElementById("root") as HTMLElement
  );
}
render();
registerServiceWorker();
