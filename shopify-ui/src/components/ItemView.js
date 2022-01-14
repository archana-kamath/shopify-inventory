import React from 'react';
import axios from 'axios';
import urls from "./utils"
import { ButtonGroup, Container, DropdownButton, Table,Card } from 'react-bootstrap';

class ItemView extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            selectValue: "",
            items:[],
            showExportButton: false,
        }
      }
    
      componentDidMount(props){
        const headers = {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin':'*',
            'Accept': 'application/json',
          }
        
        axios.get(urls.backendURL+'/shopify/item/view-all',{
            headers:headers
        })
        .then(response => response.data)
        .then((data) => {
          console.log(data)
          this.setState({
              items:data
        })
       });

    }


    exportItem=(event)=>{
        event.preventDefault();

        const postData = {
            itemName: this.state.itemName,
            itemCategory: this.state.itemCategory,
            itemPrice: this.state.itemPrice,
            totalPrice: this.state.totalPrice,
            itemQuantity: this.state.itemQuantity,
            itemRemaining: this.state.itemRemaining,
            supplierId: this.state.supplierId
          }
          axios.post(urls.backendURL+'/shopify/item/add', postData).then(response => response.data)
          .then((data) => {
            console.log(data)

            this.setState({
                isValid: true
            })
          });

     }


     render() {

        return (
                <Container fluid>
                    <Card style={{ width: '60rem' }}><Card.Body> 
                {(this.state.items.length === 0) ? (
				<div><h5> No Items in the inventory </h5></div>
			   ):(
        <div>
          <Table>
            {this.state.items.length === 0 ? (<div></div>):(
            <thead>
              <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Category</th>
                  <th>Per Price</th>
                  <th>Total Price</th>
                  <th>Quantity on Arrival</th>
                  <th>Remaining Quantity</th>
                  <th>Supplier ID</th>
                  <th>Arrival Time</th>
                  <th>Updated Time</th>
                  <th>View</th>

              </tr>
            </thead> 
            )}
          {this.state.items.map(item => (
            <tbody>
              <tr key={item.itemId}>
                <td>{item.itemId}</td>
                <td>{item.itemName}</td>
                <td>{item.itemCategory}</td>
                <td>{item.itemPrice}</td>
                <td>{item.totalPrice}</td>
                <td>{item.itemQuantity}</td>
                <td>{item.itemRemaining}</td>
                <td>{item.supplierId}</td>
                <td>{item.arrivalTime}</td>
                <td>{item.updatedTime}</td>
                <td><a href={item.itemURL} target="_blank" rel="noreferrer noopener">{item.itemName}</a></td>                
              </tr>
            </tbody>
          ))}
        </Table>
      </div>)} 
      </Card.Body></Card>
                </Container>
                )
    }
}

export default ItemView;
