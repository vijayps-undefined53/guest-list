const loginreducer = (login = false, action) => {
  switch (action) {
    case "login":
      return true;
    default:
      return false;
  }
};
export default loginreducer;
