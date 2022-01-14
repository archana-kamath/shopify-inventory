import React from 'react';
import { Container, Card, ButtonGroup,Form,Button, FormControl,Row, Col } from 'react-bootstrap';
import axios from 'axios';
import urls from "./utils"

class ItemUpdate extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            itemId:'',
            itemName:'',
            itemCategory:'',
            itemPrice:'',
            totalPrice:'',
            itemQuantity:'',
            itemRemaining:'',
            inStock:'',
            supplierId:'',
            arrivalTime:'',
            updatedTime:'', 
        }
      }
    
    handleItemIdChange = (e) => {
        this.setState({ itemId: e.target.value });
    }    
    handleItemNameChange = (e) => {
        this.setState({ itemName: e.target.value });
    }
    handleItemCategoryChange = (e) => {
        this.setState({ itemCategory: e.target.value });
    }
    handleItemPriceChange = (e) => {
        this.setState({ itemPrice: e.target.value });
    }
    handleTotalPriceChange = (e) => {
        this.setState({ totalPrice: e.target.value });
    }
    handleItemQuantityChange = (e) => {
        this.setState({ itemQuantity: e.target.value });
    }
    handleItemRemainingChange = (e) => {
        this.setState({ itemRemaining: e.target.value });
    }
    handleSupplierChange = (e) => {
        this.setState({ supplierId: e.target.value });
    }


    updateItem=(event)=>{
        event.preventDefault();

        const postData = {
            itemId:this.state.itemId,
            itemName: this.state.itemName,
            itemCategory: this.state.itemCategory,
            itemPrice: this.state.itemPrice,
            totalPrice: this.state.totalPrice,
            itemQuantity: this.state.itemQuantity,
            itemRemaining: this.state.itemRemaining,
            supplierId: this.state.supplierId
          }
          axios.post(urls.backendURL+'/shopify/item/update', postData).then(response => response.data)
          .then((data) => {
            console.log(data)

            this.setState({
                isValid: true
            })
          });

          alert("Updated Successfully")
     }


     render() {

        return (
                <Container fluid>
                    <Card style={{ width: '60rem' }}><Card.Body> 
                        <div class="col d-flex justify-content-center">
                        <form onSubmit={this.updateItem}>
                                <Form.Group as={Row} className="mb-5" controlId="1">
                                    <Form.Label column sm="6"><div><h5>Update Item in Inventory</h5></div></Form.Label>
                                    <Form.Control type="text" placeholder="Item ID" value={this.state.itemId} onChange={this.handleItemIdChange}/>
                                    <Form.Control type="text" placeholder="Item Name" value={this.state.itemName} onChange={this.handleItemNameChange}/>
                                    <Form.Control type="text" placeholder="Item Category" value={this.state.itemCategory} onChange={this.handleItemCategoryChange}/>
                                    <Form.Control type="text" placeholder="Item Price" value={this.state.itemPrice} onChange={this.handleItemPriceChange}/>
                                    <Form.Control type="text" placeholder="Total Price" value={this.state.totalPrice} onChange={this.handleTotalPriceChange}/>
                                    <Form.Control type="text" placeholder="Quantity on Arrival" value={this.state.itemQuantity} onChange={this.handleItemQuantityChange}/>
                                    <Form.Control type="text" placeholder="Quantity Remaining" value={this.state.itemRemaining} onChange={this.handleItemRemainingChange}/>
                                    <Form.Control type="text" placeholder="Supplier ID" value={this.state.supplierId} onChange={this.handleSupplierChange}/>
                                    
                                </Form.Group>
                                <Button type="submit" variant="dark" size="md" active>UPDATE</Button>
                                &nbsp;If the item is not present, a new entry will be added.
                                &nbsp;Add Item ID and the detail(s) that you want to update.
                            </form>
                            </div>
                    </Card.Body></Card>
                </Container>
                )
    }

}

export default ItemUpdate;
