<template>
    <v-card outlined>
        <v-card-title>
            RegisterUser
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <Email offline label="Email" v-model="value.email" :editMode="editMode" @change="change"/>
            <Password offline label="Password" v-model="value.password" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerUser"
            >
                RegisterUser
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
        name: 'RegisterUserCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
            this.value.name = '';
            this.value.email = {};
            this.value.password = {};
        },
        watch: {
        },
        methods: {
            registerUser() {
                this.$emit('registerUser', this.value);
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

