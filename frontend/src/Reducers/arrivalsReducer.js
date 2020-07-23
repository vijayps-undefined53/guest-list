const arrivalsReducer = (arrivals = [], action) => {
  switch (action.type) {
    case "arrivals":
      return action.payload;
    default:
      return [];
  }
};
export default arrivalsReducer;
