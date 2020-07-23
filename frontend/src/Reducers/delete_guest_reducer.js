const delete_guest_reducer = (deleted = false, action) => {
  switch (action.type) {
    case "delete_guest_action":
      return action.payload;
    default:
      return false;
  }
};
export default delete_guest_reducer;
