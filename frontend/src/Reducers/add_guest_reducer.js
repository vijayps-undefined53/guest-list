const add_guest_reducer = (add_guest = false, action) => {
  console.log("add add_guest_reducer  ");
  switch (action.type) {
    case "add_guest_action":
      return action.payload;
    default:
      return false;
  }
};
export default add_guest_reducer;
