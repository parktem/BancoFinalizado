import React from "react";


export default class Delete extends React.Component {

	constructor(props) {
		super(props)
		this.state = { numero: props.numero }
    }
    
    delete(event){
        fetch('/api/v1/user/delete/user/?numero='+this.state.numero)
        
    }

  render() {
		
		return (
				<button onClick={this.delete.bind(this)}>
					borrar dni
				</button>
			)
		

    
  }
}