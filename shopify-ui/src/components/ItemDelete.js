import React from 'react';
import { DropdownButton,Container, Card, ButtonGroup,Form,Button, Dropdown,Row, Col } from 'react-bootstrap';
import axios from 'axios';
import urls from "./utils"

class ItemDelete extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            selectValue: "",
            items:[],
            showDeleteButton: false
        }
      }

      componentDidMount(props){
        
        axios.get(urls.backendURL+'/shopify/item/view-all').then(response => response.data)
        .then((data) => {
          console.log(data)
          this.setState({items:data})
       });
    }
    
      handleDeleteDropdownChange = selectedOption => {
        console.log(selectedOption)

        this.setState({showDeleteButton:true})
        this.setState({selectValue:selectedOption})

       console.log(`Show value`,this.state.showDeleteButton)
       console.log(`Selected Value`,this.state.selectValue)

    }

    onItemDelete = () => {

        const postData = {
            itemId:this.state.selectValue
        }
        
        axios.post(urls.backendURL+'/shopify/item/delete',postData).then(response => response.data)
             .then((data) => {
             console.log(data)
        });  

        alert("Deleted Item from Inventory")
    }

     render() {

        return (
                <Container fluid>
                    <Card style={{ width: '60rem' }}><Card.Body> 
                        <div class="col d-flex justify-content-center">
                        <form>
                                <Form.Group as={Row} className="mb-5" controlId="1">
                                    <Form.Label column sm="10"><div><h5>Delete Item from Inventory</h5></div></Form.Label>
                                    <ButtonGroup>
                                    <DropdownButton variant="dark" as={ButtonGroup} title="Select the ID of item to delete" id="bg-nested-dropdown" 
                                        onSelect={this.handleDeleteDropdownChange} value={this.state.selectValue}>
                                    
                                        {this.state.items.map(item => (
                                            
                                            <Dropdown.Item eventKey={item.itemId}>{item.itemId+"-"+item.itemName+"-"+item.supplierId}</Dropdown.Item>

                                        ))}
                                    </DropdownButton>&nbsp;
                                    
                                    {this.state.showDeleteButton?(
                                        
                                        <Button onClick={this.onItemDelete} type="submit" variant="dark" size="sm" active>DELETE</Button>
                                    ):(<div></div>)}
                                    {this.state.selectValue}
                                    </ButtonGroup>
                                </Form.Group>
                                
                            </form>
                            </div>
                    </Card.Body></Card>
                </Container>
                )
    }

}

export default ItemDelete;
