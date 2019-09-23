import * as React from 'react';
import './App.css';


// class BeerList extends React.Component<{}, any> {
class BeerList extends React.Component<{}, any> {

  constructor(props: any) {
    super(props);

    this.state = {
      beers: [],
      isLoading: true
    }
  }

  public componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8080/beers')
      .then(response => response.json())
      .then(data => this.setState({beers: data, isLoading: false}));
  }


  public render() {
    // const {beers, isLoading} = this.state;
    const isLoading = this.state.isLoading;
    const beers = this.state.beers;

    if (isLoading) {
      return <p>Loading...</p>
    }

    return (
      <div className="BeerList">
        <div>
          <h2>Beer List</h2>
          {beers.map((beer: any) => 
            <div key={beer.id}>
              {beer.name}
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default BeerList;
