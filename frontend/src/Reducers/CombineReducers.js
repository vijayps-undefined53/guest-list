import { combineReducers } from "redux";
import arrivalsReducer from "./arrivalsReducer";
import loginreducer from "./loginreducer";
import add_guest_reducer from "./add_guest_reducer";
import delete_guest_reducer from "./delete_guest_reducer";

const rootreducer = combineReducers({
  arrivalsReducer,
  loginreducer,
  add_guest_reducer,
  delete_guest_reducer
});

export default rootreducer;
