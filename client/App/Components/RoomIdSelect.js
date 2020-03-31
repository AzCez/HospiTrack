import React from 'react'
import { View, Button } from 'react-native'
import { Helpers, Fonts } from '../Theme';
import { TextInput, InteractionManager } from 'react-native';
import PropTypes from 'prop-types';

class RoomIdSelect extends React.Component {
  // Used to store reference to input element
  inputRef = React.createRef();

  constructor(props) {
    super(props);
    this.state = {
      roomId: null
    }
  }

  componentDidMount() {
    this.focusInputWithKeyboard()
  }
  
  // Make keyboard pop open by focos on input element.
  focusInputWithKeyboard() {
    InteractionManager.runAfterInteractions(() => {
      this.inputRef.current.focus()
    });
  }
  
  onRoomIdChange = (roomId) => {
    // Only modify if new roomId is number
    if (isNaN(roomId)) {
      return;
    }

    this.setState({
      roomId: roomId.trim()
    });
  }

  clear = () => {
    const roomId = null;
    this.setState({
      roomId
    });
    // Let container know we cleared.
    this.props.onClear();
  }

  onSubmit = () => {
    this.props.onSubmit(this.state.roomId);
  }

  render() {
    const { onSubmit, onRoomIdChange, clear, inputRef } = this;
    const { roomId } = this.state;
    const isDisabled = !roomId;

    return (
      <View>
        <View style={Helpers.colCenter}>
          <TextInput  
            placeholder="Enter Room ID"
            underlineColorAndroid='transparent'  
            style={[Helpers.textCenter, Fonts.normal]}
            value={roomId}
            onChangeText={(newVal) => onRoomIdChange(newVal)}
            keyboardType='numeric'
            ref={inputRef}
          />
        </View>
        <View style={[Helpers.row, Helpers.scrollSpaceBetween]}>
          <View style={{width: '40%'}}>
            <Button disabled={isDisabled} title="OK" onPress={onSubmit}></Button>
          </View>
          <View style={{width: '40%'}}>
            <Button disabled={isDisabled} color="grey" title="clear" onPress={clear}></Button>
          </View>
        </View>
      </View>

    );
  }
}

RoomIdSelect.propTypes = {
  onSubmit: PropTypes.func.isRequired,
  onClear: PropTypes.func.isRequired
};

export default RoomIdSelect;