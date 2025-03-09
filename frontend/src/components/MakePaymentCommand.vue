<template>
    <v-card outlined>
        <v-card-title>
            MakePayment
        </v-card-title>

        <v-card-text>
            <String label="PaymentId" v-model="value.paymentId" :editMode="editMode"/>
            <Money offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="makePayment"
            >
                MakePayment
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
        name: 'MakePaymentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.paymentId = '';
            this.value.amount = {};
            this.value.status = '';
        },
        watch: {
        },
        methods: {
            makePayment() {
                this.$emit('makePayment', this.value);
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

