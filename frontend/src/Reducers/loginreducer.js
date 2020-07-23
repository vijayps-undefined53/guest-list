const loginreducer = (login = false, action) => {
  switch (action.type) {
    case "login": {
      return action.payload.status === 200;
    }
    default:
      return false;
  }
};
export default loginreducer;
