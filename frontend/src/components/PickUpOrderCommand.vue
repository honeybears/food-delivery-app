<template>
    <v-card outlined>
        <v-card-title>
            PickUpOrder
        </v-card-title>

        <v-card-text>
            <String label="DeliveryId" v-model="value.deliveryId" :editMode="editMode"/>
            <String label="Driver" v-model="value.driver" :editMode="editMode"/>
            <Address offline label="Address" v-model="value.address" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="pickUpOrder"
            >
                PickUpOrder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PickUpOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.deliveryId = '';
            this.value.driver = '';
            this.value.address = {};
        },
        watch: {
        },
        methods: {
            pickUpOrder() {
                this.$emit('pickUpOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

